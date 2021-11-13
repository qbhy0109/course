import numpy as np
import hashlib as ha
import time

t=[]#存储挖矿时间

def find_gold(d):
    startTime = time.perf_counter()#记录开始时间
    text=""
    for i in range(0,d):
        text = text + '0'
    n = 1
    while True:
        x = np.random.randint(0,100000000)
        string = str(x)#随机数x转换为字符串
        utf_str=string.encode('utf-8')#进行'utf-8'编码

        h = ha.sha256()    #采用sha256加密
        h.update(utf_str)    #加载数据
        b = h.hexdigest()       #获取哈希值
        n= n + 1#计算次数
        if b[0:d] == text:
            costTime = time.perf_counter() - startTime#耗时=结束时间-开始时间
            print('随机数：{}'.format(x),'用时:{}'.format(costTime))
            print('哈希值：%s'%b)
            print('挖矿次数：%d'%n)
            print('挖矿成功！')
            break;
    t.append(costTime)#将此次耗时加入列表中
    
if __name__ == '__main__':
    for d in range(1,6):
        print('挖矿难度d：%d'%d)
        for i in range(0,3):
            find_gold(d)
        average_t = sum(t[3*(d-1):3*d]) / 3.0
        print('平均时间：{}'.format(average_t))
        print('\n')
