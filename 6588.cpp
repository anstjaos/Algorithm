#include <iostream>
using namespace std;

bool primeNum[1000001];
int num;

void init()
{
	for (int i = 2; i < 1000001; i++) primeNum[i] = true;

	for (int i = 2; i < 1000001; i++)
	{
		if (primeNum[i] == true)
		{
			for (int j = i * 2; j < 1000001; j += i) primeNum[j] = false;
		}
	}
}

int main()
{
	init();
	while (1)
	{
		bool flag = false;
		scanf(" %d", &num);

		if (num == 0) break;

		for (int i = 3; i < 1000001; i++)
		{
			if (primeNum[i] == true && primeNum[num-i] == true)
			{
				printf("%d = %d + %d\n", num, i, num - i);
			
				flag = true;
				break;
			}
		}

		if (flag == false)
		{
			printf("Goldbach's conjecture is wrong.\n");
		}
	}
	return 0;
}