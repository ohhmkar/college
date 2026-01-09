# Question 1

```c
void backupSimulation(int n,char start,char end,char temp){
    if(n==1){
        printf("Move file 1 from Server %c to Server %c\\n",start,end);//Break condition is if n==1, that means only the first file is left to be transferred
        return;
    }

    backupSimulation(n-1,start,temp,end);//Recursive call for second file
    printf("Move file %d from Server %c to Server %c\\n",n,start,end);
    backupSimulation(n-1,temp,end,start);//Recursive call for next file
}
```

# Question 2

```c
void reverseWord(char str\[\], int start, int end) {
    if (start \>= end) return;

    char temp \= str\[start\];
    str\[start\] \= str\[end\];
    str\[end\] \= temp;

    reverseString(str, start \+ 1, end \- 1);
}
```
