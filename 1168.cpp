#include <iostream>
using namespace std;

bool arr[100001];
int cnt = 0;
int checkCnt;
int N, M;

int main()
{
	cin >> N >> M;

	int next = 0;
	cout << "<";
	while (cnt != N)
	{
		checkCnt = 0;
		while (checkCnt != M)
		{
			next = (next + 1) % (N + 1);
			if (next == 0) next++;
			if (arr[next] == false)
			{
				checkCnt++;
				
			}
			
		}
		arr[next] = true;
		if (cnt == N - 1) cout << next << ">" << endl;
		else cout << next << ", ";

		cnt++;
	}
	return 0;
}