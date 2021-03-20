#include <iostream>
using namespace std;

int arr[10001];
int index = 0;
int n;
int k;

int main()
{
	cin >> n >> k;

	for (int i = 1; i <= n; i++)
	{
		if (n % i == 0)
		{
			arr[index++] = i;
		}
	}

	cout << arr[k - 1] << endl;
}