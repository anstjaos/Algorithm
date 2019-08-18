#include <iostream>
using namespace std;

int stack[100001], top = -1, n;
char result[200001];
int resultCnt, arr[100001];
int curNum = 1;

void push(int item)
{
	top++;
	stack[top] = item;
}

int getTop() { return stack[top]; }

void pop() { top--; }

bool isEmpty() { return top == -1; }

bool solve()
{
	for (int i = 0; i < n; i++)
	{
		if (arr[i] > curNum)
		{
			while (curNum <= arr[i])
			{
				push(curNum);
				curNum++;
				result[resultCnt++] = '+';
			}
			if (!isEmpty())
			{
				pop();
				result[resultCnt++] = '-';
			}
			
		}
		else if (arr[i] == curNum)
		{
			curNum++;
			result[resultCnt++] = '+';
			result[resultCnt++] = '-';
		}
		else
		{
			if (getTop() == arr[i] && !isEmpty())
			{
				pop();
				result[resultCnt++] = '-';
			}
			else return false;
		}
	}

	return true;
}

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++) cin >> arr[i];
	if (solve())
	{
		for (int i = 0; i < resultCnt; i++) cout << result[i] << "\n";
	}
	else cout << "NO\n";
}