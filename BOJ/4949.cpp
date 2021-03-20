#include <iostream>
#include <string>
using namespace std;

string input;
char stack[1002];
int top;

void push(char item)
{
	stack[++top] = item;
}

char pop()
{
	char temp = stack[top];
	top--;
	return temp;
}

int main()
{
	while (1)
	{
		top = -1;
		bool flag = true;
		getline(cin, input);
		if (input == ".") break;
		int size = input.length();
		for (register int i = 0; i < size; i++)
		{
			if (input[i] == '(' || input[i] == '[') push(input[i]);
			if (input[i] == ')')
			{
				if (top == -1) {
					flag = false; break;
				}
				char temp = pop();
				if (temp != '(') {
					flag = false;
					break;
				}
			}
			else if (input[i] == ']')
			{
				if (top == -1) {
					flag = false; break;
				}
				char temp = pop();
				if (temp != '[') {
					flag = false;
					break;
				}
			}
		}

		if (flag == false) printf("no\n");
		else
		{
			if(top != -1) printf("no\n");
			else printf("yes\n");
		}

		//cin.ignore();
	}

	return 0;
}