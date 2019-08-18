#include <iostream>
using namespace std;	

int s1, s2, s3;
int cntArr[101];

int main()
{
	cin >> s1 >> s2 >> s3;

	for (int i = 1; i <= s1; i++)
	{
		for (int j = 1; j <= s2; j++)
		{
			for (int k = 1; k <= s3; k++) cntArr[i + j + k]++;
		}
	}

	int cnt = 0;
	int result;
	for (int i = 3; i <= s1 + s2 + s3; i++)
	{
		if (cntArr[i] > cnt)
		{
			cnt = cntArr[i];
			result = i;
		}
	}

	cout << result << "\n";
	return 0;
}