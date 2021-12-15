filename='D:\Course\数字信号处理\data_100_快走_20151008.txt';
data=load(filename);
timestamp = data(3);
x = data(4);
y = data(5);
z = data(6);
% [a1,a2,a3,a4]=textread('test.txt','%d,%d,%d,%d','headerlines',4)
