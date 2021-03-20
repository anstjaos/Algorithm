#include <iostream>
using namespace std;

int arrSize;
int conCnt;
int arr[1000];
int temp;
int result = -1000;

int main()
{
	cin >> arrSize >> conCnt;
	for (int i = 0; i < arrSize; i++) cin >> arr[i];

	for (int i = 0; i < arrSize - conCnt + 1; i++)
	{
		temp = 0;
		for (int j = 0; j < conCnt; j++)
		{
			temp = temp + arr[i+j];
		}
		if (temp > result) result = temp;
	}
	cout << result << endl;
	return 0;
}