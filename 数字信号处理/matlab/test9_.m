N = 5000;
n = 0:N-1;
yx = 2*pi*n/N;
a = 0.8;
X = 1./(1-a*exp(-2i*pi*n/N));
plot(yx,abs(X));