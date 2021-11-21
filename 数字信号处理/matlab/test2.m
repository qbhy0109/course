T0 = 10;
n = 0:0.05:T0;
y = exp(n);
figure
plot(n,y);
figure
X = linspace(0,2);
Y = X.^3;
Z = exp(X).*cos(Y);
h = stem3(X,Y,Z,'filled');
h.Color = 'm';
h.MarkerFaceColor = 'y';
view(-10,35)