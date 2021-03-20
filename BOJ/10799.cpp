#include <iostream>
#include <string>
using namespace std;

typedef struct {
	char value;
	int order;
}bracket;

char preChar = ' ';
string input;
bracket lazer[100001];
int lazerCount = 0;
bracket stack[100001];
int top = 0;
int result = 0;

void push(bracket item)
{
	stack[top++] = item;
}

void pop()
{
	top--;
}

bracket getTop()
{
	return stack[top - 1];
}

int checkLazer(bracket bc)
{
	int cnt = 0;
	for (int i = 0; i < lazerCount; i++)
	{
		if (bc.order < lazer[i].order) cnt++;
	}
	return cnt;
}

int main()
{
	cin >> input;
	int length = input.length();
	for (int i = 0; i < length; i++)
	{
		bracket temp;
		if (preChar == '(' && input[i] == ')')
		{
			temp = getTop();
			pop();
			lazer[lazerCount++] = temp;
		}
		else if (input[i] == '(')
		{
			temp.value = input[i];
			temp.order = i;
			push(temp);
		}
		else if (input[i] == ')')
		{
			temp = getTop();
			pop();
			result = result + checkLazer(temp) +1;
		}
		preChar = input[i];
	}
	cout << result << endl;
	return 0;
}