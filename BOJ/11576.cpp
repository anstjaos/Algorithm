#include <iostream>
using namespace std;

int a;
int b;
int m;
int arr[26];
int resultArr[100];
int cnt = 0;
int sum = 0;

int power(int num)
{
	int result = 1;
	for (int i = 0; i < num; i++)
	{
		result = result * a;
	}
	return result;
}

int main()
{
	cin >> a >> b >> m;
	for (int i = m; i > 0; i--) cin >> arr[i];
	for (int i = m; i > 0; i--)
	{
		sum = sum + arr[i] * power(i-1);
	}

	while (sum > 0)
	{
		resultArr[cnt++] = sum % b;
		sum = sum / b;
	}
	for (int i = cnt - 1; i >= 0; i--)
	{
		cout << resultArr[i] << " ";
	}
	cout << endl;
	return 0;
}