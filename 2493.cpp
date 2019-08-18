#include <stdio.h>
#define STACK_SIZE 500001

typedef struct {
	int index;
	int height;
}Top;
int N, top;
Top stack[STACK_SIZE];

void push(Top item)
{
	stack[++top] = item;
}

Top pop()
{
	return stack[top--];
}

int main()
{
	scanf("%d", &N);
	int num = 0;
	for (register int i = 1; i <= N; i++)
	{
		scanf("%d", &num);
		
		while (1)
		{
			if (top == -1) {
				printf("0 ");
				break;
			}

			if (stack[top].height > num) {
				printf("%d ", stack[top].index);
				break;
			}
			pop();
		}
		push({ i,num });
	}
	printf("\n");
	return 0;
}