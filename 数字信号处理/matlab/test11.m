W = 20;     
W0 = 2;
T0 = 5;
fs = 100;   % ²ÉÑùÆµÂÊ
w = 0:1/fs:W-0.1;
l = length(w);
Y1 = T0*sinC(0.5*T0.*(w-W0));
plot(w*fs/W,abs(Y1));

function x = sinC(a)
    if(a==0)
        x=1;
    else
        x = sin(a)./a;
    end
end