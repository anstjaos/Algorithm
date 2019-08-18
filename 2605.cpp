#include <iostream>
using namespace std;

int arr[101];
int cnt;
int num;

int main()
{
	cin >> cnt;
	for (int i = 1; i <= cnt; i++)
	{
		cin >> num;
		
		if (arr[num] == 0) arr[num] = i;
		else
		{
			for (int j = i-2; j >= num; j--)
			{
				arr[j + 1] = arr[j];
			}
			arr[num] = i;
		}
	}

	for (int i = cnt - 1; i >= 0; i--) cout << arr[i] << " ";
	cout << endl;
}