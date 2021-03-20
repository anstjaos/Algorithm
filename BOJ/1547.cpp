#include <iostream>
using namespace std;

int arr[4];
int M, num1, num2;

int main()
{
	for (int i = 1; i < 4; i++) arr[i] = i;

	cin >> M;

	for (int i = 0; i < M; i++)
	{
		cin >> num1 >> num2;

		int index1, index2;

		for (int j = 1; j < 4; j++)
		{
			if (arr[j] == num1) index1 = j;
			if (arr[j] == num2) index2 = j;
		}
		swap(arr[index1], arr[index2]);
	}

	cout << arr[1] << endl;
	return 0;
}