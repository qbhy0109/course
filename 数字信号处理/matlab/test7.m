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

figure
W = 20;
W0 = pi;
T0 = 2;
fs = 100;    % ²ÉÑùÆµÂÊ
w = 0:1/fs:2*pi;
l = length(w);
% Y1 = T0*sinC(0.5*T0.*(w-W0));
Y1 = sinC(W/2,(w-W0)/2);
% plot(w,(Y1));
y = plot(w,abs(Y1));
axis([0 2*pi 0 10]);
set(y,'XTick',0:pi:2*pi);


% W = 20;
% W0 = 2;
% T0 = 10;
% w = 0:0.1:W-0.1;
% l = length(w);
% % Y1 = T0*sinC(0.5*T0.*(w-W0));
% Y1 = sinC(w-W0);
% subplot(121)
% plot(w,abs(Y1));
% 
% t = 0:0.1:T0-0.1;
% x = exp(1i*W0.*t);
% Y2 = fft(x);
% subplot(122)
% plot(t,abs(Y2));


function x = sinC(N,a)
%     if(mod(a,pi)==0)
    if(a == 0)
        x=N;
    else
        x = sin(N*a)./sin(a);
    end
end

% 
% function x = sinC(a)
%     if(a==0)
%         x=1;
%     else
%         x = sin(a)./a;
%     end
% end

