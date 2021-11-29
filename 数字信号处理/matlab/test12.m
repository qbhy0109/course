N1 = 10;    N2 = 20;
W0 = pi;
fs = 100;    % ²ÉÑùÆµÂÊ
w = 0:1/fs:2*pi;
subplot(211)
Y1 = sinC(N1,(w-W0)/2);
plot(w,abs(Y1/N1));title("N = 10");
axis([0 2*pi 0 1]);
subplot(212)
Y2 = sinC(N2,(w-W0)/2);
plot(w,abs(Y2/N2));title("N = 20");
axis([0 2*pi 0 1]);

function x = sinC(N,a)
    if(a == 0)
        x=N;
    else
        x = sin(N*a)./sin(a);
    end
end