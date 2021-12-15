clear all;clc;

% I = imread('E:\Digital image and video processing\work\proj01-images\Fig0338(a)(blurry_moon).tif');
I = imread('Fig0338(a)(blurry_moon).tif');
J = log(im2double(I)+1);
K = fft2(J);
n = 5;
D0 = 0.1*pi;
rh = 0.9;
rl = 0.4;
[row, column] = size(J);
for i=1:row
    for j=1:column
       D1(i, j) = sqrt(i^2+j^2);
       H(i,j) = rl+(rh/(1+(D0/D1(i,j)^(2*n))));
    end
end
L = K.*H;
M = ifft2(L);
N = exp(M)-1;
figure
subplot(211);imshow(I);title("Ô­Í¼");
subplot(212);imshow(real(N));title("ÂË²¨");
