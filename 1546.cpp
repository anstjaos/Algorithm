#include <iostream>
using namespace std;

int arr[1001];
int cnt;
double maxNum = 0.0;

int main()
{
	cin >> cnt;
	for (int i = 0; i < cnt; i++)
	{
		cin >> arr[i];
		if (arr[i] > maxNum) maxNum = arr[i];
	}

	double result = 0;

	for (int i = 0; i < cnt; i++)
	{
		result = result + (arr[i] * 100.0 / maxNum);
	}
	printf("%.2f\n", result / cnt);
	return 0;
}