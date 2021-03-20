//#include <iostream>
//using namespace std;
//
//bool check[1001], dir; // true = right, false = left
//int balloon[1001], cnt;
//
//void solve()
//{
//	int printCount = 0;
//	int cur = 0;
//
//	while (1)
//	{
//		cout << cur + 1 << " ";
//		printCount++;
//		check[cur] = true;
//
//		if (printCount == cnt) break;
//
//		if (balloon[cur] > 0) dir = true;
//		else dir = false;
//
//		int next = (cur + balloon[cur] + cnt) % cnt;
//
//		while (check[next])
//		{
//			if (dir == true) next = (next + 1) % cnt;
//			else next = (next - 1 + cnt) % cnt;
//		}
//		cur = next;
//	}
//}
//
//int main()
//{
//	cin >> cnt;
//
//	for (int i = 0; i < cnt; i++) cin >> balloon[i];
//	solve();
//	cout << endl;
//	return 0;
//}

#include <iostream>
using namespace std;

typedef struct a{
	int num, cnt;
	a* left;
	a* right;

	a() {}
	a(int i_num, int i_cnt, a* i_left, a* i_right)
	{
		num = i_num;
		cnt = i_cnt;
		left = i_left;
		right = i_right;
	}
}balloon;

int cnt, temp;
balloon *first;

void solve()
{
	balloon* cur = first;
	int next, printCnt = 0;

	while (1)
	{
		cout << cur->num << " ";
		next = cur->cnt;
		cur->left->right = cur->right;
		cur->right->left = cur->left;
		balloon *temp = cur;
		printCnt++;

		if (printCnt == cnt) break;
		if (next < 0)
		{
			cur = cur->left;
			next++;

			next = next * -1;
			for (int i = 0; i < next; i++)
			{
				cur = cur->left;
			}
		}
		else
		{
			cur = cur->right;
			next--;

			for (int i = 0; i < next; i++)
			{
				cur = cur->right;
			}
		}

		delete temp;
	}
	cout << "\n";
}

int main()
{
	cin >> cnt;
	balloon *pre;
	balloon* cur;
	for (int i = 1; i <= cnt; i++)
	{
		cin >> temp;
		if (i == 1)
		{
			first = new balloon(i, temp, 0, 0);
			pre = first;
		}
		else
		{
			cur = new balloon(i, temp, pre, first);
			pre->right = cur;
			first->left = cur;
			pre = cur;
		}
	}

	solve();
}