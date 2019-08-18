#include <iostream>
using namespace std;

int testCase;
int cnt;
int arr[101];
int arrCount = 0;

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		arrCount = 0;
		cin >> cnt;
		for (int j = 0; j < cnt; j++) cin >> arr[arrCount++];
		
		for (int j = 0; j < arrCount; j++)
		{
			for (int k = j + 1; k < arrCount; k++)
			{

			}
		}
	}
}