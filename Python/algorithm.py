#-*-coding:utf8-*-
import datetime;
import hashlib;
import functools;
import random;

# 通过MD5值比较大小
def compareByMd5(a,b):
    if(hashlib.md5(str(a).encode()).hexdigest()>hashlib.md5(str(b).encode()).hexdigest()):
        return 1
    elif(hashlib.md5(str(a).encode()).hexdigest()<hashlib.md5(str(b).encode()).hexdigest()):
        return -1
    return 0

# 计算方法执行时间的修饰器
def countTime(func):
    @functools.wraps(func)
    def __decorator(*args):
        starttime=datetime.datetime.now()
        result = func(*args)
        endtime = datetime.datetime.now()
        print("call function:"+func.__name__,endtime-starttime)
        return result;
    return __decorator
##########################################   排序    ########################
# 插入排序
@countTime
def insertSort(inputlist):
    for i,x in enumerate(inputlist):        
        if(i>1):
            needle=x          
            for j,y in enumerate(inputlist[0:i-1]):
                if(compareByMd5(y,needle)>=0):
                    temp=y
                    inputlist[j]=needle
                    needle=temp
            inputlist[i]=needle
    return inputlist;

# 冒泡排序
@countTime
def bubbleSort(inputlist):
    for i,x in enumerate(inputlist):
        for j,y in enumerate(inputlist[-2:i:-1]):
            if(compareByMd5(inputlist[j],inputlist[j+1])):
                temp=inputlist[j]
                inputlist[j]=inputlist[j+1]
                inputlist[j+1]=temp
    return inputlist

# 查找排序
@countTime            
def querySort(inputlist):
    if(len(inputlist)<1):
        return inputlist
    
    for i,x in enumerate(inputlist):
        minvalue = inputlist[i]
        index = i   
        for j,y in enumerate(inputlist[i:]):
            if(compareByMd5(y,minvalue)<0):
                index=i
        temp=inputlist[i]
        inputlist[i]=inputlist[index]
        inputlist[index]=temp
            
    return inputlist

# 归并排序
def merageSort(inputlist,p,r):
    # 合并已排序的两个数组
    def merage(A,p,q,r):
        PQ=A[p:q]
        QR=A[q:r]
        i=0
        j=0
        index=0
        while(i<len(PQ) and j<len(QR)):
            if(compareByMd5(PQ[i],QR[j])<0):
                A[p+index]=PQ[i]
                i+=1
            else:
                A[p+index]=QR[j]
                j+=1
            index+=1
        if(i==len(PQ)):
            while(j<len(QR)):
                A[p+index]=QR[j]
                j+=1
                index+=1
        elif(j==len(QR)):
            while(i<len(PQ)):
                A[p+index]=PQ[i]
                i+=1
                index+=1
        return A
    # print(merage([1,3,5,2,4,6],0,3,6))
    # 递归
    j=(p+r)//2
    if(r-p<=1):
        return inputlist
    elif(r-p==2):
        if(compareByMd5(inputlist[p],inputlist[p+1])):
            temp=inputlist[p]
            inputlist[p]=inputlist[p+1]
            inputlist[p+1]=temp
        return inputlist
    else:
        merageSort(inputlist,p,j)
        merageSort(inputlist,j,r)
        merage(inputlist,p,j,r)

    return inputlist

@countTime
def testMerageSort(*args):
        merageSort(*args)

# 查找最大和子数组
def findMaxArray(inputlist,s,e):
    # 查找跨中界最大子数组
    def findMaxArrayCrossMiddle(inputlist,s,m,e):
        if(s==m and m==e):
            return
        leftsum,leftmax = 0,inputlist[m-1]
        leftmaxindex,leftindex = m-1,m-1
        
        while(leftindex>=s):
            leftsum += inputlist[leftindex]
            if(leftsum>leftmax):
                leftmax=leftsum
                leftmaxindex=leftindex
            leftindex-=1
        
        rightsum,rightmax = 0,inputlist[m]
        rightindex,rightmaxindex = m,m

        while(rightindex<e):
            rightsum += inputlist[rightindex]
            if(rightsum>rightmax):
                rightmax=rightsum
                rightmaxindex=rightindex
            rightindex+=1
        
        return (leftmaxindex,rightmaxindex,leftmax+rightmax)

    # print(findMaxArrayCrossMiddle([1,4,-6,8,3,-5,3,5],0,4,8))

    # 递归
    if(s==e-1):
        return (s,e,0)

    m=(s+e)//2
    (ls,le,lm)=findMaxArray(inputlist,s,m)
    (rs,re,rm)=findMaxArray(inputlist,m,e)
    (ms,me,mm)=findMaxArrayCrossMiddle(inputlist,s,m,e)

    if(lm>=rm and lm>=mm):
        return (ls,le,lm)
    elif(rm>=lm and rm>=mm):
        return (rs,re,rm)
    else:
        return (ms,me,mm)
            
# 堆排序
def heapSort(heap):
    # 构造最大堆
    def buildMaxHeap(heap,n):
        for i in range(n//2,0,-1):
            maxHeapify(heap,i,n)
    # 维持最大堆
    def maxHeapify(heap,i,size):
        l = 2*i
        r = 2*i+1
        
        if(l<=size and heap[l-1]>heap[i-1]):
            largest = l
        else:
            largest = i
        if(r<=size and heap[r-1]>heap[largest-1]):
            largest = r
        if(largest!=i):
            temp = heap[i-1]
            heap[i-1] = heap[largest-1]
            heap[largest-1] = temp
            maxHeapify(heap,largest,size) 
    # 堆排序内容
    length = len(heap)
    for i in range(length,0,-1):
        buildMaxHeap(heap,i)
        temp = heap[0]
        heap[0] = heap[i-1]
        heap[i-1] = temp
    return heap
###################################   二叉树    #######################
# 搜索二叉树
# 插入
def insertSearchBinaryTree(sbt,x):
    if(sbt.get('key') == None):
        sbt['key'] = x
        return
    while(True):
        if (sbt.get('key') < x):
            if(sbt.get('left') == None):
                sbt['left'] = {}
            return insertSearchBinaryTree(sbt.get('left'),x)
        elif (sbt.get('key') >= x):
            if(sbt.get('right') == None):
                sbt['right'] = {}
            return insertSearchBinaryTree(sbt.get('right'),x)
    pass
# 创建
def createSearchBinaryTree(list):
    sbt = {'key':list[0]}
    for x in list[1:]:
        insertSearchBinaryTree(sbt,x)
    return sbt
    pass
# 搜索
def searchSearchBinaryTree(sbt,x):
    if(sbt == None):
        return None
    if(sbt.get('right') == None):
        sbt['right'] = {}
    if(sbt.get('left') == None):
        sbt['left'] = {}
    if(sbt.get('key') < x and sbt.get('right').get('key') != None):
        return searchSearchBinaryTree(sbt.get('right'),x)
    elif(sbt.get('key') > x and sbt.get('left').get('key') != None):
        return searchSearchBinaryTree(sbt.get('left'),x)
    else:
        return sbt
    pass
# 查找前驱
def findPreNode(x):
    pass
# 删除
def deleteSearchBinaryTree(sbt,x):
    pass

    

if(__name__=="__main__"):
    # targetlist = list(range(1000,0,-1))
    # targetlist = [random.randint(0,100) for x in range(0,100)]
    # targetlist = list(range(0,1000))
    # print(targetlist)

    # insertSort(targetlist)
   
    # bubbleSort(targetlist)
    
    # querySort(targetlist)

    # testMerageSort(targetlist,0,len(targetlist))

    # print(findMaxArray(targetlist,0,len(targetlist)))

    # print(heapSort(list([16,4,10,14,7,9,3])))

    # sbt = createSearchBinaryTree(targetlist)
    # print(searchSearchBinaryTree(sbt,2))
    # pass
 

        