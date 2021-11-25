P = 4;
N = 20;
% l = N/P;
w = ones(1,2*N); % 长度为N的矩形序列
n = 0:2*N-1;
x = exp(1i*2*pi/P*n);
y = w.*x;
Y = fft(y);
stem(n,abs(Y));


% 
% close all;
% clear all
% dt=0.01;
% t=-4:dt:4;
% ft=(t+4)/2.*((t+4)>=0)-t.*(t>=0)+((t-4)>=0);
% N=2000;
% k=-N:N;
% w=pi*k/(N*dt);
% F=dt*ft*exp(-1j*t'*w);
% F=abs(F);
% plot(w,F),grid on
% axis([-pi pi -1 9])