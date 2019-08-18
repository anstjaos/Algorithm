#include <iostream>
using namespace std;

bool computer[101];
int cnt, num, result;

int main()
{
	cin >> cnt;
	for (int i = 0; i < cnt; i++)
	{
		cin >> num;
		if (computer[num] == true) result++;

		computer[num] = true;
	}

	cout << result << endl;
	return 0;
}