#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string order[100001];
int orderCnt, stack[10001];
int top = -1;
int numArr[100001], numCnt;

void push(int item)
{
	top++;
	stack[top] = item;
}

void pop() { top--; }

void init() { top = -1; }

bool isEmpty() { return top == -1; }

int getTop() { return stack[top]; }


bool solve(int num)
{
	push(num);
	numCnt = 0;
	for (int i = 0; i < orderCnt; i++)
	{
		if (order[i] == "NUM")
		{
			push(numArr[numCnt]);
			numCnt = numCnt + 1;
		}
		else if (order[i] == "POP")
		{
			if (isEmpty()) return false;
			pop();
		}
		else if (order[i] == "INV")
		{
			if (isEmpty()) return false;
		
			int temp = getTop();
			pop();
			push(temp*-1);
		}
		else if (order[i] == "DUP")
		{
			if (isEmpty()) return false;
			push(getTop());
		}
		else if (order[i] == "SWP")
		{
			if (top < 1) return false;
			int num1 = getTop();
			pop();
			int num2 = getTop();
			pop();

			push(num1);
			push(num2);
		}
		else if (order[i] == "ADD")
		{
			if (top < 1) return false;

			int num1, num2;
			
			num1 = getTop();
			pop();

			num2 = getTop();
			pop();

			if (abs(num1 + num2) > 1e9)  return false;
		
			push(num1 + num2);
		}
		else if (order[i] == "SUB")
		{
			if (top < 1) return false;
			int num1, num2;
			
			num1 = getTop();
			pop();
			
			num2 = getTop();
			pop();

			if (abs(num2 - num1) > 1e9) return false;
			
			push(num2 - num1);
		}
		else if (order[i] == "MUL")
		{
			if (top < 1) return false;
			int num1, num2;
			
			num1 = getTop();
			pop();
			
			num2 = getTop();
			pop();
			long long result = (long long)num1 * (long long)num2;
			if (abs(result) > 1e9) return false;
			
			push(num2 * num1);
		}
		else if (order[i] == "DIV")
		{
			if (top < 1) return false;
			int num1, num2;
			
			num1 = getTop();
			pop();
			if (num1 == 0) return false;
			
			num2 = getTop();
			pop();
			int result =abs( num2 )/ abs(num1);
			if ((num1 >= 0 && num2 >= 0) || (num1 < 0 && num2 < 0))
			{
				push(result);
			}
			else
			{
				push(result*-1);
			}
		}
		else if (order[i] == "MOD")
		{
			if (top < 1) return false;
			int num1, num2;
		
			num1 = getTop();
			pop();
			if (num1 == 0) return false;

			num2 = getTop();
			pop();

			int result = abs(num2) % abs(num1);
			if (num2 < 0)
			{

				push(result * -1);
			}
			else
			{
				push(result);
			}
		}
	}

	if (top == 0) return true;

	return false;
}

int main()
{
	string temp;
	bool first = true;

	while (1)
	{
		if (first == true) first = false;
		else printf("\n");
		int cnt, num;

		orderCnt = 0;
		numCnt = 0;
		while (1)
		{
			cin >> temp;
			if (temp == "QUIT") return 0;
			if (temp == "END") break;
			if (temp == "NUM")
			{
				scanf("%d", numArr + numCnt);
				numCnt = numCnt + 1;
			}
			order[orderCnt++] = temp;
		}
		
		scanf("%d", &cnt);
		for (int i = 0; i < cnt; i++)
		{
			init();
			scanf("%d", &num);

			if (solve(num)) printf("%d\n",getTop());
			else
			{
				printf("ERROR\n");
			}
		}
	}
	return 0;
}