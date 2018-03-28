using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading;


namespace C_
{
    class Program
    {
         
        static void Main(string[] args)
        {
            int[] temp = new int[]{5,6,7,8,9,10};
            Random rd = new Random();
            for(int i = 0;i<6 ;i++){
                int index = rd.Next(0,6);
                int tmp = temp[0];
                temp[0] = temp[index];
                temp[index] = tmp;
            }

            foreach(int o in temp){
                Console.WriteLine(o);
            }
        }


        private static void Hanoi(Stack<int> source,Stack<int> target,Stack<int> assist,int retain1,int retain2,int retain3){
            if(source.Count<=retain1){
                return;
            }
            else if(source.Count==retain1 + 1){
                target.Push(source.Pop());
                return;
            }
            else
            {
                
                Hanoi(source, assist, target,retain1+1,retain3,retain2);
                target.Push(source.Pop());
                Hanoi(assist, target, source,retain3,retain2+1,retain1);
            }
        }

        
    }
}
