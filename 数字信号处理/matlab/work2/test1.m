clear; clc; close all;
y=load('D:\Course\数字信号处理\data_100_快走_20151008.txt');       % 读入加速度数据
x=detrend(y);                % 消除趋势项
fs=100;                      % 采样频率
N=length(x);                 % 数据长度
time=(0:N-1)/fs;             % 时间刻度
% 用findpeaks函数求峰值位置
[Val,Locs]=findpeaks(x,'MINPEAKHEIGHT',20,'MINPEAKDISTANCE',35);%最小峰高度  最小峰之间距离
T1=time(Locs);               % 取得加速度时刻
M1=length(T1);
T11=T1(2:M1);
T12=T1(1:M1-1);
Mdt1=mean(T11-T12);          % 从峰值得的平均周期值
fprintf('峰值求得的平均周期值=%5.4f\n',Mdt1);
% 作图
plot(time,x,'k'); hold on; grid;
plot(time(Locs),Val,'ro','linewidth',3);
xlabel('时间/s'); ylabel('幅值'); title('加速度信号波形图')
set(gcf,'color','w');