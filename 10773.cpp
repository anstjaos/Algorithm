#include <iostream>
using namespace std;

int stack[100001];
int top = -1, K, temp;

void push(int item)
{
	stack[++top] = item;
}

void pop()
{
	top--;
}

int main()
{
	scanf("%d", &K);
	for (register int i = 0; i < K; i++) {
		scanf("%d", &temp);
		if (temp == 0) pop();
		else push(temp);
	}

	long long sum = 0;
	for (register int i = 0; i <= top; i++) sum += stack[i];

	printf("%lld\n", sum);
	return 0;
}