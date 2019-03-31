#include <iostream>
using namespace std;

int arr[1002];
int n, q, query, a,b,c,d;

int main()
{
	cin >> n >> q;

	for (int i = 1; i <= n; i++) cin >> arr[i];
	for (int i = 0; i < q; i++)
	{
		cin >> query;
		long long result = 0;
		if (query == 1)
		{
			cin >> a >> b;

			for (int j = a; j <= b; j++)
			{
				result = result + arr[j];
			}
			swap(arr[a], arr[b]);
		}
		else if (query == 2)
		{
			cin >> a >> b >> c >> d;
			for (int j = a; j <= b; j++)
			{
				result = result + arr[j];
			}
			for (int j = c; j <= d; j++) result = result - arr[j];
		}
		cout << result << endl;
	}
	return 0;
}