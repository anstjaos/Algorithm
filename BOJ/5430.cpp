#include <iostream>
#include <string>
using namespace std;

#define QUEUE_SIZE 5000001
int tc, cnt, front, rear;
string order, input;
int queue[QUEUE_SIZE];
bool rev;

void push(int item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

void fPop()
{
	front = (front + 1) % QUEUE_SIZE;
}

void rPop()
{
	rear = (rear - 1 + QUEUE_SIZE) % QUEUE_SIZE;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		rev = false;
		front = rear = -1;
		bool flag = false;
		cin >> order;
		scanf("%d", &cnt);
		cin >> input;
		int size = input.size();
		int num = 0;
		for (register int i = 1; i < size - 1; i++)
		{
			if ('0' <= input[i] && input[i] <= '9')
			{
				num = num * 10 + (input[i] - '0');
			}
			else
			{
				push(num);
				num = 0;
			}
		}
		if(num !=0) push(num);

		size = order.size();
		for (register int i = 0; i < size; i++)
		{
			if (order[i] == 'R') rev = !rev;
			else if (order[i] == 'D')
			{
				if (front == rear)
				{
					flag = true;
					break;
				}

				if (rev) rPop();
				else fPop();
			}
		}

		if (flag) printf("error\n");
		else
		{
			printf("[");
			if (!rev)
			{
				for (register int i = front + 1; i <= rear; i++)
				{
					if (i == rear) printf("%d]\n", queue[i]);
					else printf("%d,", queue[i]);
				}
			}
			else {
				for (register int i = rear; i >front; i--)
				{
					if (i == front+1) printf("%d]\n", queue[i]);
					else printf("%d,", queue[i]);
				}
			}

			if (front == rear) printf("]\n");
		}
	}

	return 0;
}