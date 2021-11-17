Fs=200;% 假定采样频率是200Hz
t=(1:1600)/Fs;
am=(1:2:64)*sin(2*pi*(1:2:64)'.*t);

h=fft(am);
h(1)=[];% 去除直流分量
minF=Fs/length(am);% fft的最小分频率辨率
Fstep=2;% 分段频率步长
y=zeros(length(am),32);% 频率分解后的信号

for m1=1:32
    temp=(m1-1)*Fstep/minF:m1*Fstep/minF;
    index=[1+temp length(h)-temp];
    h1=zeros(size(h));
    h1(index)=h(index);
    y(:,m1)=ifft([0 h1]);% y的对应列的信号就是需要的
end
