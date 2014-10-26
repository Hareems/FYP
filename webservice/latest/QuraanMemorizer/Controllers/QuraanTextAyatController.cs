using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class QuraanTextAyatController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/QuraanTextAyat
        public IQueryable<QuraanTextAyat> GetQuraanText(string Id = null,string Aayatno = null, string juzzId = null)
        {
            if (juzzId != null && Id == null && Aayatno == null)
                return db.QuraanText.Where(s => s.JuzzId == int.Parse(juzzId) && s.SurrahId == int.Parse(Id) && s.AayatNo == int.Parse (Aayatno));
            if (Id != null)
                return db.QuraanText.Where(s => s.SurrahId == int.Parse(Id) && s.AayatNo == int.Parse(Aayatno));
            if (Aayatno != null)
                return db.QuraanText.Where(s=> s.AayatNo ==int.Parse(Aayatno));
            return db.QuraanText;
        }

        // GET api/QuraanTextAyat/5
        [ResponseType(typeof(QuraanTextAyat))]
        public IHttpActionResult GetQuraanTextAyat(int id)
        {
            QuraanTextAyat quraantextayat = db.QuraanText.Find(id);
            if (quraantextayat == null)
            {
                return NotFound();
            }

            return Ok(quraantextayat);
        }

        // PUT api/QuraanTextAyat/5
        public IHttpActionResult PutQuraanTextAyat(int id, QuraanTextAyat quraantextayat)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != quraantextayat.Id)
            {
                return BadRequest();
            }

            db.Entry(quraantextayat).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!QuraanTextAyatExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/QuraanTextAyat
        [ResponseType(typeof(QuraanTextAyat))]
        public IHttpActionResult PostQuraanTextAyat(QuraanTextAyat quraantextayat)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.QuraanText.Add(quraantextayat);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = quraantextayat.Id }, quraantextayat);
        }

        // DELETE api/QuraanTextAyat/5
        [ResponseType(typeof(QuraanTextAyat))]
        public IHttpActionResult DeleteQuraanTextAyat(int id)
        {
            QuraanTextAyat quraantextayat = db.QuraanText.Find(id);
            if (quraantextayat == null)
            {
                return NotFound();
            }

            db.QuraanText.Remove(quraantextayat);
            db.SaveChanges();

            return Ok(quraantextayat);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool QuraanTextAyatExists(int id)
        {
            return db.QuraanText.Count(e => e.Id == id) > 0;
        }
    }
}