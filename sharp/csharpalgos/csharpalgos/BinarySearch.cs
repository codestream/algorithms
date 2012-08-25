using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace csharpalgos
{
    public static class BinarySearch
    {
        public static int binarySearchFirst(bool[] a)
        {
            int lo = -1;
            int hi = a.Length;
            while (hi - lo > 1)
            {
                int mid = (lo + hi) / 2;
                if (!a[mid])
                {
                    lo = mid;
                }
                else
                {
                    hi = mid;
                }
            }
            return hi;
        }

        public static int binarySearchLast(bool[] a)
        {
            int lo = -1;
            int hi = a.Length;
            while (hi - lo > 1)
            {
                int mid = (lo + hi) / 2;
                if (!a[mid])
                {
                    lo = mid;
                }
                else
                {
                    hi = mid;
                }
            }
            return lo;
        }

        public static int binarySearchFirst2(bool[] a)
        {
            int lo = 0;
            int hi = a.Length;
            while (lo < hi)
            {
                int mid = (lo + hi) / 2;
                if (!a[mid])
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid;
                }
            }
            return lo;
        }

        public static int binarySearchLast2(bool[] a)
        {
            int lo = -1;
            int hi = a.Length - 1;
            while (lo < hi)
            {
                int mid = (lo + hi + 1) / 2;
                if (!a[mid])
                {
                    lo = mid;
                }
                else
                {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        public static int binarySearch(long[] a, long key)
        {
            int lo = 0;
            int hi = a.Length - 1;
            while (lo <= hi)
            {
                int mid = (lo + hi) / 2;
                long midVal = a[mid];
                if (midVal < key)
                {
                    lo = mid + 1;
                }
                else if (midVal > key)
                {
                    hi = mid - 1;
                }
                else
                {
                    return mid;
                }
            }
            return -(lo + 1);
        }

        public static int stl_lower_bound(long[] a, long key)
        {
            int lo = -1;
            int hi = a.Length;
            while (hi - lo > 1)
            {
                int mid = (lo + hi) / 2;
                long midVal = a[mid];
                if (midVal < key)
                {
                    lo = mid;
                }
                else
                {
                    hi = mid;
                }
            }
            return hi;
        }

        public static int stl_upper_bound(long[] a, long key)
        {
            int lo = -1;
            int hi = a.Length;
            while (hi - lo > 1)
            {
                int mid = (lo + hi) / 2;
                long midVal = a[mid];
                if (midVal <= key)
                {
                    lo = mid;
                }
                else
                {
                    hi = mid;
                }
            }
            return hi;
        }

        public static void Main(String[] args) 
        {
	        bool[] b = { false, false, true };
	        Console.WriteLine(2 == binarySearchFirst(b));
	        Console.WriteLine(1 == binarySearchLast(b));

	        long[] a = { 1, 3, 7, 10, 15 };
            Console.WriteLine(4 == stl_upper_bound(a, 11));
	    }
    }
}
