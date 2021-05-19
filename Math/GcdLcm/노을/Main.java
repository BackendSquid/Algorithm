package com.example.BOJ.codeplus.basic1.최대공약수와최소공배수_2609;

import java.util.*;

public class Main{

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);  // a, b 정렬할 필요 없음, 알아서 정렬됨.
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b)); // gcd : 최대공약수
        System.out.println(a*b/gcd(a,b)); //lcm : 최소공배수

    }
}
