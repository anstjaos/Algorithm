#include <iostream>
using namespace std;

int arr[100001];
int cnt;
int input, sticker = 0, maxNum = -1;

int main()
{
	cin >> cnt;
	for (int i = 0; i < 2*cnt; i++)
	{
		cin >> input;
		if (arr[input] == 0)
		{
			
			sticker++;
		}
		else if (arr[input] == 1)
		{
			sticker--;
		}
		arr[input]++;
		if (sticker > maxNum) maxNum = sticker;
	}

	cout << maxNum << endl;
	return 0;
}