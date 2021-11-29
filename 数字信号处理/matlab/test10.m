  w = 2;
  fs = 5;
  N = 60;
  t = 0:1/fs:N-1;
  x = exp(1i*w.*t);
  n = length(x);
%   plot(t,abs(x));
  figure
  y = fft(x);
  p = (0:n-1)*fs/N;
  plot(p,abs(y));