package com.shuai.android.suanfa;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/10
 * Time:下午7:05
 */
public class Demo {

    //选择矩阵
    /**
     *  1 2 3
     *  4 5 6
     *  7 8 9
     **/
    public static void main(String args[]){
        int data [][] =new int [][] {{1,2,3},{4,5,6},{7,8,9}};
        //rotate(data);
        //print1(data);
        reverse(data);
        print1(data);
    }

    //将矩阵转置
    public static void reverse(int temp [][] ){
        for(int i=0;i<temp.length;i++){
            for(int j=i;j<temp[i].length;j++){
                int k=temp[i][j];
                temp[i][j]=temp[j][i];
                temp[j][i]=k;
            }
        }
    }



    //旋转90度
    public static void rotate(int temp[][]){
        int len=temp.length;
        int b [][]=new int [len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                b[j][len-1-i]=temp[i][j];
            }
        }
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                temp[i][j]=b[i][j];
    }
    //输出
    public static void print1(int temp[][]){
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
                System.out.print(temp[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
