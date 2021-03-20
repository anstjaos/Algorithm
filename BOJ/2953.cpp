#include <iostream>

using namespace std;

int arr[6] = { 0, };
int sum = 0;
int num;
int m = 0;
int maxindex = 0;

int main()
{
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cin >> num;
			sum = sum + num;
		}
		arr[i] = sum;
		if (sum > m)
		{
			maxindex = i;
			m = sum;
		}
		sum = 0;
	}
	cout << maxindex+1 << " " << arr[maxindex] << endl;
	
}