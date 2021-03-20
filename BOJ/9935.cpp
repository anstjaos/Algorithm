#include <stdio.h>

char stack[1000005];
char bomb[40];
char input[1000005];
int top = -1;
bool flag;
char temp[40];

void push(char item)
{
	stack[++top] = item;
}

bool isEmpty()
{
	return top == -1;
}

void pop()
{
	if (isEmpty()) return;
	top--;
}

char getTop()
{
	if (isEmpty()) return 0;
	return stack[top];
}

int strlen(char *s)
{
	int len = 0;
	while (s[len] != 0) len++;
	return len;
}

void strcat(char *s, char c)
{
	int len = strlen(s);
	s[len] = c;
	s[len + 1] = '\0';
}

int main()
{
	scanf("%s %s", input, bomb);
	int length = strlen(input);
	int bomblength = strlen(bomb);

	if (bomblength > length)
	{
		printf("%s\n", input);
		return 0;
	}

	for (int i = 0; i < length; i++)
	{
		if (input[i] == bomb[bomblength - 1])
		{
			int cnt = bomblength - 1;
			strcat(temp, bomb[cnt]);
			while (1)
			{
				cnt--;

				if (cnt < 0)
				{
					flag = true;
					break;
				}

				if (isEmpty() || getTop() != bomb[cnt])
				{
					flag = false;
					break;
				}
				else
				{
					strcat(temp, getTop());
					pop();
				}
			}

			if (flag == false)
			{
				int count = strlen(temp);
				for (int i = count - 1; i >= 0; i--)
				{
					push(temp[i]);
					temp[i] = '\0';
				}
			}
		}
		else push(input[i]);
	}
	if (isEmpty() == true) printf("FRULA\n");
	else
	{
		push('\0');
		for (register int i = 0; i < top; i++) {
			printf("%c", stack[i]);
		}
		printf("\n");
	}

	return 0;
}