sample_rate = 100;
speriod = 1/sample_rate;
total_time = 1;
t = 0:speriod:total_time-speriod;
frequency = 50;
s = sin(2*pi*frequency.*t);
subplot(211);
plot(t,s);
subplot(212)
calculate_fft=fft(s);
absolute_value=abs(calculate_fft); 
L=length(s);  
hpts=L/2;
sfft_mag_scaled=absolute_value/hpts; 
plot(sfft_mag_scaled)
