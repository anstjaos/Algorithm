#include <iostream>
using namespace std;

bool arr[1001];
int n, m, cnt;

int main()
{
	cin >> n >> m;
	int cur = 0, index = -1;
	cout << "<";
	while (cnt != n)
	{
		while (1)
		{
			index = (index + 1) % n;
			if (arr[index] == false)
			{
				cur++;
			}

			if (cur == m) break;
			
		}

		arr[index] = true;
		cur = 0;
		cnt++;
		cout << index + 1;
		if(cnt != n) cout << ", ";
	}
	cout << ">\n";
	return 0;
}