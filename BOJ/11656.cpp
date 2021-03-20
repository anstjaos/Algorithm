#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string input;
string arr[1001];
int cnt = 0;


int main()
{
	cin >> input;
	int length = input.length();

	for (int i = 0; i < length; i++)
	{
		string temp = "";
		for (int j = i; j < length; j++)
		{
			temp = temp + input[j];
		}
		arr[i] = temp;
		cnt++;
	}
	sort(arr, arr + cnt);
	for (int i = 0; i < cnt; i++)
	{
		cout << arr[i] << endl;
	}
	return 0;
}