#include <iostream>
using namespace std;

int arr[1001];

void init()
{
	int num =1;
	int cnt =0;
	for (int i = 1; i <= 1000; i++)
	{
		arr[i] = num;
		cnt++;
		if (cnt == num)
		{
			num++;
			cnt = 0;
		}
	}
}

int main()
{
	int a, b;

	cin >> a >> b;
	int result = 0;
	init();
	for (int i = a; i <= b; i++)
	{
		result += arr[i];
	}
	cout << result << endl;
	return 0;
}