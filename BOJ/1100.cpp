#include <iostream>
using namespace std;

char arr[65];
int result = 0;
int cnt = 0;

int main()
{
	for (int i = 0; i < 64; i++) cin >> arr[i];
	
	for (int i = 0; i < 64;)
	{
		if (arr[i] == 'F') result++;
		cnt++;
		if (cnt == 4)
		{
			if (i % 2 == 0) i = i + 3;
			else i++;

			cnt = 0;
		}
		else i = i + 2;
	}
	cout << result << endl;
}