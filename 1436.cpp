#include <iostream>
#include <string>
using namespace std;

int N, cnt;

int main()
{
	scanf("%d", &N);
	int num = 665;
	while (cnt != N)
	{
		num++;
		string s = to_string(num);
		int size = s.size();
		int temp = 0;

		for (register int i = 0; i < size; i++)
		{
			if (temp == 3) break;

			if (s[i] == '6') temp++;
			else temp = 0;
		}

		if (temp == 3) cnt++;
	}

	printf("%d\n", num);
	return 0;
}