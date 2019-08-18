#include <iostream>
using namespace std;

int start[30001], A, B;
int num = 2;

void init()
{
	start[1] = 1;
	while (1)
	{
		start[num] = start[num - 1] + num - 1;
		num++;
		if (start[num] > 1000) break;
	}
}

int findNum(int a)
{
	int result;
	for (int i = 1; i < num; i++)
	{
		if (start[i] <= a && a < start[i + 1])
		{
			result = i;
			break;
		}
	}

	return result;
}

int main()
{
	init();
	cin >> A >> B;
	int result = 0;

	while (1)
	{
		int temp = findNum(A);
		if (B >= start[temp+1]) result += temp * (start[temp + 1] - A);
		else
		{
			result += (B - A + 1) * temp;
			break;
		}

		A = start[temp + 1];
	}

	cout << result << "\n";
	return 0;
}