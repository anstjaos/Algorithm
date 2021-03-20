#include <iostream>
using namespace std;

int A, P;
int arr[1000001];
int result;
int pow1(int num, int cnt)
{
	int result = 1;
	for (int i = 0; i < cnt; i++)
	{
		result = result * num;
	}

	return result;
}

int findNum(int num)
{
	int result = 0;

	while (num != 0)
	{
		result = result + pow1(num % 10, P);
		num = num / 10;
	}
	return result;
}

int main()
{
	cin >> A >> P;
	arr[1] = A;
	int index = 2;
	bool flag = false;
	while (1)
	{
		arr[index] = findNum(arr[index - 1]);
		for (int i = 1; i < index; i++)
		{
			if (arr[index] == arr[i])
			{
				flag = true;
				result = i;
				break;
			}
		}

		if (flag == true) break;
		index++;
	}

	cout << result - 1 << '\n';
	return 0;
}