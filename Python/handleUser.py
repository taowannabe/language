# -*- coding:utf-8 -*-
import hashlib

def handFileByRow(handleRow,filePath,outPath):
    with open(filePath,'r',encoding='utf-8') as f:
        rows = f.readlines()
    with open(outPath,'w',encoding='utf-8') as outf:
        outf.writelines(map(handleRow,rows))
def md5Row(row):
    return hashlib.md5(str(row).encode()).hexdigest()+'\n'

if(__name__ == "__main__"):
    handFileByRow(md5Row,"d://temp.csv","d://temp2.csv")
