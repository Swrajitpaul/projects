# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
def fib(n):
    if(n==1):
        return 1
    if(n ==0):
        return 1
    return fib(n-1) + fib(n-2)

print(fib(4))