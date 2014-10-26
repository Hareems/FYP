using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace QuraanMemorizer.Models
{
    public enum Grade
    {
        A, B, C, D, F
    }
    public class Sabaq
    {
        [Key]
        public int Guid { get; set; }
        public DateTime SabaqDate { get; set; }
        public int QuranTextAyatStartId { get; set; }
        public int QuranTextAyatEndId { get; set; }
        public string QariComments { get; set; }
        public bool IsHeard { get; set; }
        public string Audio { get; set; }
        public string QariResponseFile { get; set; }
        [DisplayFormat(NullDisplayText = "No grade")]
        public Grade? Grade { get; set; }
        public int ReciterId { get; set; }
        public int StudentId { get; set; }
        public int QariId { get; set; }
        public  QuraanTextAyat QuraanTextAyatStart { get; set; }
        public  QuraanTextAyat QuraanTextAyatEnd { get; set; }
        public  Reciter Reciter { get; set; }
        public ApplicationUser Student { get; set; }
        public ApplicationUser Qari { get; set; }
    }
}