# -*- coding: utf-8 -*-
"""
Created on Fri Jun 22 03:12:36 2018

@author: swrajit
"""

# Paste your code into this box
print('Please think of a number between 0 and 100!')
low = 0
high = 100
guess = (high+low)//2
st =""
while(st !='c'):
    print("Is your secret number "+ str(guess) + '?')
    st = input('Enter \'h\' to indicate the guess is too high. Enter \'l\' to indicate the guess is too low. Enter \'c\' to indicate I guessed correctly.')
    while(st != 'c' or st != 'h' or st != 'l'):
        print('Expected: Sorry, I did not understand your input.')
        st = input('Enter \'h\' to indicate the guess is too high. Enter \'l\' to indicate the guess is too low. Enter \'c\' to indicate I guessed correctly.')
    if(st =='l'):
        low = guess
        guess = (high + low)//2
    elif(st =='h'):
        high= guess
        guess=(high + low)//2
print('Game over. Your secret number was: '+ str(guess))
