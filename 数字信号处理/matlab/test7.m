% w = 2;
% fs = 5;
% N = 60;
% t = 0:1/fs:N-1;
% x = exp(1i*w.*t);
% n = length(x);
% % plot(t,abs(x));
% 
% y = fft(x);
% p = (0:n-1)*fs/N;
% plot(p,abs(y));

W = 20;
W0 = 2;
T0 = 10;
w = 0:0.1:W-0.1;
l = length(w);
Y1 = T0*sinC(0.5*T0.*(w-W0));
subplot(121)
plot(w,abs(Y1));

t = 0:0.1:T0-0.1;
x = exp(1i*W0.*t);
Y2 = fft(x);
subplot(122)
plot(t,abs(Y2));


function x = sinC(a)
    if(a==0)
        x=0;
    else
        x = sin(a)./a;
    end
end
























